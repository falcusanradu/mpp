using System;

namespace model
{
    public class User
    {
        [Key]
        public Integer id { get; set; }
        public String username { get; set; }
        public String password { get; set; }
        public String fullname { get; set; }
        public String address { get; set; }
    }
}