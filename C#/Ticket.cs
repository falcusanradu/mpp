using System;
namespace model
{
    public class Ticket
    {
        [Key]
        public Integer id { get; set; }
        public String description { get; set; }
        public String seat { get; set; }
        public String price { get; set; }
    }
}