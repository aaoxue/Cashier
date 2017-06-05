1. git init
2. mvn idea:idea
3. Add as maven project。
4. 看一下pom.xml。
5. 测试项目是否配置正确。
6. 第一次提交。
7. 需求分析。
8. 任务分解。
    *计算购物车单商品折扣价格。
    *计算购物车商品第二件半价
    *计算购物车商品总价。
    *打印购物清单
9. 选择任务。
    * 依赖性。
    * 重要性。
10. 判断每次的猜测结果。
11. 分析测试样本和驱动对象的职责。
12. 测试样本的选择(实例化需求)
    * 简单。
    * 针对业务进行测试，而不是针对方法进行测试。
13. 正确计算购物车中的折扣商品。
    * 需求
        * 购物车中有一折扣商品，正确算出商品应付金额。
    * 意图
        * 实现商品的一种优惠计算。
    * 测试名称
        * should_return_right_discount_price_when_product_in_discount_list
    * 类名及行为名
        * ChooseProduct，caculateBillDetail
        * Product
14. 使用伪实现通过第一个测试。
15. 选择第二件半价的测试样本
    * 需求
        * 用户买入2个第二件半价商品，算出商品正确应付金额。
    * 意图
        * 添加第二个半价优惠规则。
    * 测试名称
        * should_return_half_price_when_cart_has_two_product_which_in_half_list
    * 类名及行为名
        *  ChooseProduct，caculateBillDetail
15.1 选择既有折扣又有第二件半价的测试样本
    * 需求
            * 用户买入2个有折扣并且第二件半价商品，算出商品正确应付金额。
        * 意图
            * 计算符合两种优惠的单品类商品价格。
        * 测试名称
            * should_return_right_price_when_cart_has_one_product_which_in_half_list_and_discount_list
        * 类名及行为名
            *  ChooseProduct，caculateBillDetail
16. 计算购物车商品总价
    * 需求
        * 用户买入折扣商品和第二件半价商品，计算购物车商品总价
    * 意图
        * 合并计算所有优惠商品总价
    * 测试名称
        * should_return_right_total_fee_when_cart_has_more_product_with_two_different_promotion
     *类名及行为名
        * Cart,getBillDetails

