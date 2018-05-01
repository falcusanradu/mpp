using System;
namespace model
{
    public class Game
    {
        [Key]
        public Integer id { get; set; }
        public String team1 { get; set; }
        public String team2 { get; set; }
        public String title { get; set; }
        public List<Ticket> tickets { get; set; }
    }
}