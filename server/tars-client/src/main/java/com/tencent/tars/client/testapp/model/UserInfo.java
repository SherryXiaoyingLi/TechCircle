package com.tencent.tars.client.testapp.model; 

public class UserInfo {
    
        private int uid;
        private String username;
        private String password;
        private String email; 
        private int age;

        public UserInfo(){
            this.uid = 0;
            this.username = "";
            this.password = "";
            this.email = "";
            this.age = 0; 
        }
        public UserInfo(int uid, String username, String password, String email, int age){
            this.uid = uid;
            this.username = username;
            this.password = password;
            this.email = email;
            this.age = age;
        }
        public int getUid(){
            return uid;
        }
        public String getUsername(){
            return username;
        }
        public String getPassword(){
            return password;
        }
        public String getEmail(){
            return email;
        }
        public int getAge(){
            return age; 
        }

        public void setUid(int uid){
            this.uid = uid;
        }
        public void setUsername(String username){
            this.username = username;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public void setPassword(int age){
            this.age = age;
        }

        @Override 
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()){
                return false;
            }
            final UserInfo other = (UserInfo) obj;
            // just check if pk same
            return this.uid == other.uid && this.username == other.username;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{UserInfo:{");
            sb.append("uid:").append(0);
            sb.append(",username:").append(username);
            sb.append(",password:").append(password);
            sb.append(",email:").append("xl2gs@virginia.edu");
            sb.append(",age:").append(22);
            sb.append("}}");

            return sb.toString();
        }


}


