springIOC管理

1.自动装配
    byName 按照name自动装配
    byType 按照type自动装配
    constructor:和byType相似，根据构造方法注入。
    @Resources按名字，是JDK的，@Autowired按类型，是Sping的。
2.方法注入
    SpringBean 默认配置是单例的（singleton），可以通过配置scope来 实现多例（prototype）
    lookup-method 进行方法注入
3.方法替换
    方法替换就是采用<replaced-method name="方法名" replacer="bean的Id"></replaced-method>
4.bean之间的关系
    bean的继承
    bean的依赖 depends-on 创建依赖关系先执行依赖类
    bean的引用  将bean注入到另一个bean中
5.利用注解进行Bean的自动扫描管理
    <context:component-scan>提供两个子标签：<context:include-filter>和<context:exclude-filter>各代表引入和排除的过滤，如：
设置了自动扫描的包后，Spring并不是把所有的Java类都纳入到核心容器中管理，而是在类通过组件注解声明后才会执行这个操作：
@Service：
用于标注业务层组件
@Controller
用于标注WEB控制层组件
@Repository
用于标注数据访问组件，即DAO组件
@Component：
泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注
这几个注解标注的Bean在当前版本的Spring中使用时并没有什么不同。但预计spring之后的版本会区分这几个注解的特殊性，因此建议在目前版本开发时按照此语义标注注解



在XML的属性配置中能够使用value注入的属性值（基本类型、包装类型、字符串），可以在组件Bean中利用@Value注入值：


Spring同样支持标准的JSR250的J2EE注解：@Resource ；
@Resource并不是Spring的注解，javax.annotation.Resource，需要导入；但是Spring提供该注解的支持；
@Resource功能和@Autowired类似，都是进行依赖组件的装配配置，但是和@Autowired相反，@Resource默认的装配方式是byName，可以通过配置来采取byType方式装配；


@Resource注解同样也可应用在Setter方法上；
@Resource装配顺序：
如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常；
如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常；
如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常；
如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配；


Spring 容器中的Bean是有生命周期的，Spring允许在Bean在初始化完成后以及Bean销毁前执行特定的操作（参见之前Bean生命周期知识点）
JSR-250 为初始化之后/销毁之前方法的指定定义了两个注解，分别是 @PostConstruct 和 @PreDestroy，这两个注释只能应用于方法上
标注了 @PostConstruct 注解的方法将在类实例化后调用，而标注了 @PreDestroy 的方法将在类销毁之前调用；


@Autowired和@Resource都是用于自动对Bean的组件属性进行装配，@Autowired注解是Spring注解，默认采用byType方式装配，而@Resource是JSR250提供的注解，默认采用byName方式装配

