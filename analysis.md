1. git init
2. mvn idea:idea
3. Add as maven project。
4. 看一下pom.xml。
5. 测试项目是否配置正确。
6. 第一次提交。
7. 需求分析。
8. 任务分解。
    * 读取折扣商品。
    *读取半价商品。
    *读取购物车商品。
    *计算购物车单商品价格。
    *计算购物车商品总价。
9. 选择任务。
    * 依赖性。
    * 重要性。
10. 判断每次的猜测结果。
11. 分析测试样本和驱动对象的职责。
12. 测试样本的选择(实例化需求)
    * 简单。
    * 针对业务进行测试，而不是针对方法进行测试。
13. 选择0A0B的测试样本。
    * 需求
        * 用户输入完全错误的答案，返回0A0B。
    * 意图
        * 最核心的功能，简单实现。
    * 测试名称
        * should_return_0A0B_when_no_number_guessed_correctly
        * Game Should Return 0A0B When No Number Guessed Correctly
    * 类名及行为名
        * Game，guess
        * Answer
14. 使用伪实现通过第一个测试。
15. 选择4A0B的测试样本
    * 需求
        * 用户输入完全正确的答案，返回4A0B。
    * 意图
        * 进一步添加需求。
    * 测试名称
        * should_return_4A0B_when_all_number_guessed_correctly
    * 类名及行为名
        * Game，guess
        * Answer
16. 同样使用伪实现，因为还未突破重构的底线，现有的代码没有阻碍我们添加新需求。
17. 选择2A2B测试样本，三角测试法
    * 需求
        * 用户输入4个正确的数字，但是其中两个位置错误，返回2A2B。
    * 意图
        * 驱动实现。
    * 测试名称
        * should_return_2A2B_when_has_correct_number_but_wrong_position
    * 类名及行为名
        * Game，guess
        * Answer
18. 测试出现重复代码。
19. guess()方法里面的职责有点问题，使用的属性基本上都是Answer内的，识别出了代码坏味道"Feature Evny"——依赖情结。
20. 重构手法-提取函数，移动函数。
21. 第二个任务，随机生成答案。
22. 生成4位数的答案
    * 需求
        * 生成四位数的答案。
    * 意图
        * 第二核心的需求。
    * 测试名称
        * should_generator_answer
    * 类名及行为名
        * AnswerGenerator, generator
23. 重构，将GameTest里面的答案改成由AnswerGenerator生成。
24. 第三个任务，输入验证。

    * 重复验证
    * 长度验证
    * 数字验证

25. 重复验证
    * 需求
       * 重复验证。
    * 意图
       * 重复验证较为简单。
    * 测试名称
       * should_raise_error_when_answer_number_duplicated
    * 类名及行为名
       * AnswerValidator, validator
26. 长度验证
    * 需求
       * 长度验证。
    * 意图
       * 三角实现法则。
    * 测试名称
       * should_raise_error_when_answer_length_not_four
    * 类名及行为名
       * AnswerValidator, validator
27. 数字验证
    * 需求
       * 数字验证。
    * 意图
       * 三角实现法则。
    * 测试名称
       * should_raise_error_when_answer_not_digit
    * 类名及行为名
       * AnswerValidator, validator
28. 重构AnswerValidator，简化算法。抽方法，使用正则表达式。
29. 将AnswerValidator加回到Game的guess()方法。
