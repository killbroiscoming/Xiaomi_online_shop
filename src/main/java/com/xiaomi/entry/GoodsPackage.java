package com.xiaomi.entry;

public class GoodsPackage {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_package.id
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_package.info
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    private String info;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_package.goods_id
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    private Integer goodsId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_package.id
     *
     * @return the value of goods_package.id
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_package.id
     *
     * @param id the value for goods_package.id
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_package.info
     *
     * @return the value of goods_package.info
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_package.info
     *
     * @param info the value for goods_package.info
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_package.goods_id
     *
     * @return the value of goods_package.goods_id
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_package.goods_id
     *
     * @param goodsId the value for goods_package.goods_id
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}