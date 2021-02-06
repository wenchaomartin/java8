# 理解java 8 函数式编程

> 如果觉得函数式编程难以理解 ，一定是我们缺少什么知识或者研究的视角不对



## 困局

之前用匿名类去理解 java 函数式编程  ，配着 ```接口对象``` 这一套 理论 ，感觉是绕来绕去。 不得其法 



## 闭包

``返回``含有成员变量的```函数 ```

下面是一段js 代码

```JS
function a(){
	var i=0;
	return function(){
        return i++;
    }
};
add = a();
add(); //return 0
add(); //return 1
```



上面的自增的例子



**keyword :** 

- 返回函数，
- 返回的函数有之前用到的变量

思路  Java 能不能把函数付给一个变量  ```add = a()```;



java 只能赋值只能是下面

```JAVA
	List list = new ArrayList();
	ArrayList list2 = new ArrayList();
```

我们假设左边的接口类型只有一个函数签名，赋值一个接口变量 可以等同赋给一个函数变量

java 版本闭包  

```java
   Callable<Integer> callable = new Callable() {
            int i=0;
            @Override
            public Integer call () {
                return i++;
            }
        };
        // 我们看成这样的理解 callable#call = call();
        // 的确有点繁琐， 没有 将函数直接付给变量， 只能套入类的视角 ，在外面包装。
        System.out.println(callable.call());
        System.out.println(callable.call());
        System.out.println(callable.call());
```



哎 只能这样了 才会有 这些东西 @FunctionalInterface 限制接口里只有一个抽象方法。  



从这个角度在看  java 内置函数式编程的内置类

```java
        //近似 看成 accept =  (s)-> System.out.println(s);
		Consumer<String> consumer = (s)-> System.out.println(s);
        consumer.accept("hello world");
        // get = ()-> 1;
        Supplier<Integer> supplier = ()-> 1;
        System.out.println(supplier.get());
        // // apply = (s)-> ++s;
        Function<Integer,Integer> func = (s)-> ++s;
        System.out.println(func.apply(1));
```



参考：

[java8内置函数的介绍](https://www.zhihu.com/people/martinwen-chao/posts)

[Java里的闭包](https://stackoverflow.com/questions/3805474/what-is-a-closure-does-java-have-closures/3805546)