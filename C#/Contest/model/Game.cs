using System;


namespace Contest.model
{
    class Game
    {
        public int id { get; set; }
        public String team1 { get; set; }
        public String team2 { get; set; }
        public String title { get; set; }
        public int tickets { get; set; }
        public int price { get; set; }

        public override string ToString()
        {
            return id + "\t" + team1 + "\t" + team2 + "\t" + title + "\t" + tickets + "\t" + price;
        }
    }
}
