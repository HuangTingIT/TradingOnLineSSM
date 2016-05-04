package TOL2.model;

import java.math.BigDecimal;

public class Goods {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.id
     *
     * @mbggenerated
     */
    public Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.userId
     *
     * @mbggenerated
     */
    public Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.name
     *
     * @mbggenerated
     */
    public String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.category
     *
     * @mbggenerated
     */
    public String category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.num
     *
     * @mbggenerated
     */
    public Integer num;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.price
     *
     * @mbggenerated
     */
    public BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.pictures
     *
     * @mbggenerated
     */
    public String pictures;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.likeNum
     *
     * @mbggenerated
     */
    public Integer likenum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.isSold
     *
     * @mbggenerated
     */
    public Integer issold;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.description
     *
     * @mbggenerated
     */
    public String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbggenerated
     */
    public Goods(Integer id, Integer userid, String name, String category, Integer num, BigDecimal price, String pictures, Integer likenum, Integer issold, String description) {
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.category = category;
        this.num = num;
        this.price = price;
        this.pictures = pictures;
        this.likenum = likenum;
        this.issold = issold;
        this.description = description;
    }

    public  Goods(){}
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.id
     *
     * @return the value of goods.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.userId
     *
     * @return the value of goods.userId
     *
     * @mbggenerated
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.name
     *
     * @return the value of goods.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.category
     *
     * @return the value of goods.category
     *
     * @mbggenerated
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.num
     *
     * @return the value of goods.num
     *
     * @mbggenerated
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.price
     *
     * @return the value of goods.price
     *
     * @mbggenerated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.pictures
     *
     * @return the value of goods.pictures
     *
     * @mbggenerated
     */
    public String getPictures() {
        return pictures;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.likeNum
     *
     * @return the value of goods.likeNum
     *
     * @mbggenerated
     */
    public Integer getLikenum() {
        return likenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.isSold
     *
     * @return the value of goods.isSold
     *
     * @mbggenerated
     */
    public Integer getIssold() {
        return issold;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.description
     *
     * @return the value of goods.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public void setIssold(Integer issold) {
        this.issold = issold;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", pictures='" + pictures + '\'' +
                ", likenum=" + likenum +
                ", issold=" + issold +
                ", description='" + description + '\'' +
                '}';
    }
}