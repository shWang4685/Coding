package course.entity;


import lombok.Data;

@Data
public class User {
        private int id;
        private String userName;
        private String password;
        private int age;
        private String sex;
        private String permission;
        private String isDelete;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public String getSex() {
                return sex;
        }

        public void setSex(String sex) {
                this.sex = sex;
        }

        public String getPermission() {
                return permission;
        }

        public void setPermission(String permission) {
                this.permission = permission;
        }

        public String getIsDelete() {
                return isDelete;
        }

        public void setIsDelete(String isDelete) {
                this.isDelete = isDelete;
        }

        @Override
        public String toString(){
              return (
              "id:"+id+","+
              "userName:"+userName+","+
              "password:"+password+","+
              "age:"+age+","+
              "sex:"+sex+","+
              "permission:"+permission+","+
              "isDelete:"+isDelete+"}"
              );
        }


}
