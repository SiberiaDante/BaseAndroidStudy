# BaseAndroidStudy

## 我的Android进阶之路
#### 1.面向对象的六大原则
    单一原则：
    开闭原则：软件中的对象(类，模块，函数等)应该对于扩展是开放的，但是对于修改是关闭的
    接口隔离原则:ISP的定义是：客户端不应该依赖它不需要的接口。另一种定义是：类间的依赖关系应该建立在最小的接口上
    依赖倒置原则：模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或抽象类产生的
    里氏替换原则：所有引用基类的地方必须能够透明地使用其子类的对象
    迪米特原则：一个对象应该对其他对象有最少的了解。通俗地讲，一个类应该对自己需要耦合或调用的类知道得最少，类的内部如何实现与调用者或者依赖者没关系，调用者或者依赖者只需要知道它需要的方法即可
2.设计模式
3.MVC
4.MVP
5.算法
6.源码
事件分发机制
自定义View
项目管理

```
HenCoder
Android进阶书
Android 开发艺术探索
项目管理
```
##### 动画
##### View
```
x,y/
```
##### 自定义View
```
布局过程：测量和绘制
    测量阶段：从上到下递归地调用每个 View 或者 ViewGroup 的 measure() 方法，测量他们的尺寸并计算它们的位置；
    布局阶段：从上到下递归地调用每个 View 或者 ViewGroup 的 layout() 方法，把测得的它们的尺寸和位置赋值给它们。
绘制过程：
两类：
    1.onMeasure()修改已有View的尺寸
    2.onMeasure()全新自定义View的尺寸
    3.重写onMeasure()和onLayout()全新自定义ViewGroup的尺寸
```
## CustomView
## DesignPattern