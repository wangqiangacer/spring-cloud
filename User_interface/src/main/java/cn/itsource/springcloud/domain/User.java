package cn.itsource.springcloud.domain;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 17:28
 */
public class User  {
    private  Long id;
    private  String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//加入构造函数  要不然没法远程调用
    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
