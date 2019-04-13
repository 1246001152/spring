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
