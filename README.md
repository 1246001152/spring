springIOC管理

1.自动装配
    byName 按照name自动装配
    byType 按照type自动装配
    constructor:和byType相似，根据构造方法注入。
    @Resources按名字，是JDK的，@Autowired按类型，是Sping的。
2.方法注入
    SpringBean 默认配置是单例的（singleton），可以通过配置scope来 实现多例（prototype）

3.方法替换