静态代理

	1） 代理对象，要实现与目标对象一样的接口；
	2） 举例:
			保存用户(模拟)
				Dao  ,  直接保存
				DaoProxy, 给保存方法添加事务处理

总结静态代理：
	1）可以做到在不修改目标对象的功能前提下，对目标对象功能扩展。
	2）缺点：
		--》  因为代理对象，需要与目标对象实现一样的接口。所以会有很多代理类，类太多。
		--》  一旦接口增加方法，目标对象与代理对象都要维护。

动态代理

	1）代理对象，不需要实现接口；
	2）代理对象的生成，是利用JDKAPI， 动态的在内存中构建代理对象(需要我们指定创建 代理对象/目标对象 实现的接口的类型；);
	3)  动态代理， JDK代理， 接口代理；

JDK中生成代理对象的API：
|-- Proxy
	static Object newProxyInstance(
    ClassLoader loader,       指定当前目标对象使用类加载器
     Class<?>[] interfaces,     目标对象实现的接口的类型
    InvocationHandler h       事件处理器
)  

动态代理总结：
	代理对象不需要实现接口，但是目标对象一定要实现接口；否则不能用动态代理！
	(class  $Proxy0  implements IuserDao)

思考：
	有一个目标对象，想要功能扩展，但目标对象没有实现接口，怎样功能扩展？
	Class  UserDao{}
	// 子类的方式
	Class subclass  extends  UserDao{}
	
	以子类的方式实现(cglib代理)


Cglib代理
Cglib代理，也叫做子类代理。在内存中构建一个子类对象从而实现对目标对象功能的扩展。

	JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。如果想代理没有实现接口的类，就可以使用CGLIB实现。 
	  CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。 
	 CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。


Cglib子类代理：
	1) 需要引入cglib – jar文件， 但是spring的核心包中已经包括了cglib功能，所以直接引入spring-core-3.2.5.jar即可。
	2）引入功能包后，就可以在内存中动态构建子类
	3）代理的类不能为final， 否则报错。
	4） 目标对象的方法如果为final/static, 那么就不会被拦截，即不会执行目标对象额外的业务方法。

	
在Spring的AOP编程中，
	如果加入容器的目标对象有实现接口，用JDK代理；
	如果目标对象没有实现接口，用Cglib代理；
AOP 面向切面的编程，
	AOP可以实现“业务代码”与“关注点代码”分离

// 保存一个用户
public void add(User user) { 
		Session session = null; 
		Transaction trans = null; 
		try { 
			session = HibernateSessionFactoryUtils.getSession();   // 【关注点代码】
			trans = session.beginTransaction();    // 【关注点代码】
			 
			session.save(user);     // 核心业务代码
			 
			trans.commit();     //…【关注点代码】

		} catch (Exception e) {     
			e.printStackTrace(); 
			if(trans != null){ 
				trans.rollback();   //..【关注点代码】

			} 
		} finally{ 
			HibernateSessionFactoryUtils.closeSession(session);   ////..【关注点代码】

		} 
   } 


分析总结：
	关注点代码，就是指重复执行的代码。
	业务代码与关注点代码分离，好处？
	   --关注点代码写一次即可；
		-开发者只需要关注核心业务；
		-运行时期，执行核心业务代码时候动态植入关注点代码； 【代理】


AOP: Aspect Oriented Programming 面向切面编程。

    主要的功能是：日志记录，性能统计，安全控制，事务处理，异常处理等等。
    主要的意图是：将日志记录，性能统计，安全控制，事务处理，异常处理等代码从业务逻辑代码中划分出来，通过对这些行为的分离，我们希望可以将它们独立到非指导业务逻辑的方法中，进而改  变这些行为的时候不影响业务逻辑的代码。

Aop，  aspect object programming  面向切面编程
	功能： 让关注点代码与业务代码分离！
关注点,
	重复代码就叫做关注点；
切面，
	 关注点形成的类，就叫切面(类)！
	 面向切面编程，就是指 对很多功能都有的重复的代码抽取，再在运行的时候网业务方法上动态植入“切面类代码”。
切入点，
	执行目标对象方法，动态植入切面代码。
	可以通过切入点表达式，指定拦截哪些类的哪些方法； 给指定的类在运行的时候植入切面类代码。

注解方式实现AOP编程
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>  开启事物注解权限

1) 使用注解
@Aspect							指定一个类为切面类		
@Pointcut("execution(* com.itmayiedu.service.UserService.add(..))")  指定切入点表达式

@Before("pointCut_()")				    前置通知: 目标方法之前执行
@After("pointCut_()")					后置通知：目标方法之后执行（始终执行）
@AfterReturning("pointCut_()")		    返回后通知： 执行方法结束前执行(异常不执行)
@AfterThrowing("pointCut_()")			异常通知:  出现异常时候执行
@Around("pointCut_()") 				    环绕通知： 环绕目标方法执行 ProceedingJoinPoint 


Xml实现aop编程：
	1） 引入jar文件 
	2） 引入aop名称空间
	3）aop 配置
		* 配置切面类 （重复执行代码形成的类）
		* aop配置
			拦截哪些方法 / 拦截到方法后应用通知代码


<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">
	
	<!-- dao 实例 -->
	<bean id="userDao" class="com.java.UserDao"></bean>
	
	<!-- 切面类 -->
	<bean id="aop" class="com.java.Aop"></bean>
	
	<!-- Aop配置 -->
	<aop:config>
		<!-- 定义一个切入点表达式： 拦截哪些方法 -->
		<aop:pointcut expression="execution(* com.java.*.*(..))" id="pt"/>
		<!-- 切面 -->
		<aop:aspect ref="aop">
			<!-- 环绕通知 -->
			<aop:around method="around" pointcut-ref="pt"/>
			<!-- 前置通知： 在目标方法调用前执行 -->
			<aop:before method="begin" pointcut-ref="pt"/>
			<!-- 后置通知： -->
			<aop:after method="after" pointcut-ref="pt"/>
			<!-- 返回后通知 -->
			<aop:after-returning method="afterReturning" pointcut-ref="pt"/>
			<!-- 异常通知 -->
			<aop:after-throwing method="afterThrowing" pointcut-ref="pt"/>
			
		</aop:aspect>
	</aop:config>
</beans>  
