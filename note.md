
## 我的Android进阶之路
#
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