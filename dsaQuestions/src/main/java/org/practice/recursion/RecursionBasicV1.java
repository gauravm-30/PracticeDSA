package org.practice.recursion;

public class RecursionBasicV1 {
  public static void learnBasicV1() {
    message();
    // Now i need to print the message 5 times
    // 1. One way is to write the sout in message() 5 times (or using the loops)
    // 2. OR call the existing function 5 times
    // 3. OR we can create similar function like message() 5 times
    message();
    message1();
    message2();
    message3();
    message4();
    // But again i don't want to do like above ,
    // 4.Now we can call the function into one another
    message();
    // 5. But again, we created separate function to call into one other.
    // 6.Now the question is , we want to call it five times but don't want to create other
    // redundant function.
    // Also I don't want to use loops and all .
    // See learnBasicV2()

  }

  public static void learnBasicV2() {
    // Observe that  when we  create separate function and  call into one other. We are basically
    // calling one function into the other and when called function is finished .It returns the
    // control to the calling function to the point where it called.
    // Like message() -> message1()

    // Write a function to print value from 1,2,3,4,5
    System.out.println("Simple");
    print1(1);

    // Now observe:
    // 1. Function calling another function
    // 2. All the function have one thing common i.e. same definition and body  i.e. taking one
    // parameter and printing it
    // 3. The last function i.e. print5() doesn't call any function i.e. we can say it as base
    // condition/end condition
    // 4.Since the body of every function is same then can we do something like this .
    //       private static void print1(int i) {
    //       System.out.println(i);
    //       print1(2);
    // Now here only parameter is changed but the body is same .
    //  }
    // 5. Now This is what recursion is, calling the function itself.
    // 6. But the problem in  above code snippet is that it will run infinitely
    // 7.So we need some base condition to  break infinite loop
    // Base condition : if(n==5){
    //                      sout;
    //                     return;
    //                          }
    // Now we can do like this also
    System.out.println("Recursive");
    // 8. Each recursive call can be treated as separate function call .
    // 9. Each call consume some memory
    // 10.Takes O(N) extra space or it depends how many calls occurs
    print1to5Recursive(1);
  }

  public static void learnBasicV3() {
    /*
     * 1.Why recursion.
     * 2.It helps in solving bigger/complex problems easily
     * 3.You can convert recursion solution into iteration and vice versa.
     * 4.First solve complex problem using recursion ,
     * then convert it into the iteration to get more optimized solution
     * 5.Space complexity is not constant because of recusrive calls
     * 6.It helps in breaking down bigger problems into the smaller problems.
     * 7.Also draw recursion tree to get more insights
     * 8.The base condition represents the answers we already have.
     * */
  }

  public static void learnBasicV4() {
    /*
     * Variables in Recursion:
     * 1. We need to properly understand which variables to use where .
     * 2. Three areas where variables are placed i.e. Arguments , Return Types and Body of function
     *
     * */
  }

  public static void learnBasicV5() {
    /*
     * Types of Recurrence relation:
     * 1.Linear recurrence relation
     * Ex: Fib(N) = Fib(N-1) + Fib(N-2);  Fibonacci series
     * 2.Divide Recurrence relation
     * Ex: BinSearch(N) = O(1) {for comparison} +
     *  BinSearch(N/2)
     *  {Dividing array into the two parts and search into it . }
     * */
  }

  private static void print1to5Recursive(int i) {
    // base condition , breaking condition, condition where recursion will stop
    if (i == 6) {
      return;
    }
    // OR
    //    if (i == 5) {
    //      System.out.println(i);
    //      return;
    //    }
    System.out.println(i);
    print1to5Recursive(i + 1);
  }

  private static void print1(int i) {
    System.out.println(i);
    print2(2);
  }

  private static void print2(int i) {
    System.out.println(i);
    print3(3);
  }

  private static void print3(int i) {
    System.out.println(i);
    print4(4);
  }

  private static void print4(int i) {
    System.out.println(i);
    print5(5);
  }

  private static void print5(int i) {
    System.out.println(i);
  }

  // write a function that prints the hello world
  private static void message() {
    System.out.println("Hello World");
    message1();
  }

  private static void message1() {
    System.out.println("Hello World");
    message2();
  }

  private static void message2() {
    System.out.println("Hello World");
    message3();
  }

  private static void message3() {
    System.out.println("Hello World");
    message4();
  }

  private static void message4() {
    System.out.println("Hello World");
  }
}
