jdk的反射api比较简单,但实现复杂功能很麻烦. 

org.reflections 工具包不止实现反射的工具集成, 更主要的是对运行时meta信息的扫描和分析.

这些meta信息主要有, resource, annotation, reflection 这几种信息. 相比来讲, annotation和reflection比较有用, 而 resource有其他更好的工具.

github 地址
-- https://github.com/ronmamo/reflections

官方文档介绍了Reflections类的api 和 ReflectionUtil 工具类.

官方提供了编译时以maven插件方式生成meta数据清单的方案, 避免runtime扫描分析的时间损耗和资源占用.

Reflections使用, 设置url → 设置scanner → 设置filter

