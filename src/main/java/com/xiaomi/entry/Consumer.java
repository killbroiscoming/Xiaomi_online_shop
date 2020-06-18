package com.xiaomi.entry;

public class Consumer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumer.id
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumer.username
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumer.password
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumer.email
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumer.phone
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    private String phone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumer.id
     *
     * @return the value of consumer.id
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumer.id
     *
     * @param id the value for consumer.id
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumer.username
     *
     * @return the value of consumer.username
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumer.username
     *
     * @param username the value for consumer.username
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumer.password
     *
     * @return the value of consumer.password
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumer.password
     *
     * @param password the value for consumer.password
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumer.email
     *
     * @return the value of consumer.email
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumer.email
     *
     * @param email the value for consumer.email
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumer.phone
     *
     * @return the value of consumer.phone
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumer.phone
     *
     * @param phone the value for consumer.phone
     *
     * @mbg.generated Thu Jun 11 21:31:19 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Consumer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Consumer(Integer id, String username, String password, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}