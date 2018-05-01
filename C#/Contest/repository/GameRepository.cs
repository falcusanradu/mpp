using Contest.model;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Contest.repository
{
    class GameRepository : IGameRepository
    {
        DataBaseConnection db;
        public GameRepository(DataBaseConnection db)
        {
            this.db = db;
        }

        public List<Game> ReturnGames()
        {
            List<Game> games = new List<Game>();
            db.OpenConnection();
            string stmt = "SELECT * FROM game g";
            MySql.Data.MySqlClient.MySqlCommand cmd = new MySql.Data.MySqlClient.MySqlCommand(stmt, db.myConnection);
            
            var reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Game game = new Game { id = reader.GetInt32("game_id"), team1 = reader.GetString("home"), team2 = reader.GetString("away"), title = reader.GetString("title"), tickets = reader.GetInt16("nr_seats"), price = reader.GetInt32("price")};
                games.Add(game); 
            }

            db.CloseConnection();
            reader.Close();
            return games;
        }

        public void UpdateSeats(int nr_seats, int game_id)
        {
            db.OpenConnection();
            string stmt = "UPDATE game SET nr_seats = nr_seats -@nr_seats WHERE game_id = @game_id ";
            MySqlCommand cmd = new MySqlCommand(stmt, db.myConnection);
            cmd.Parameters.AddWithValue("@nr_seats", nr_seats);
            cmd.Parameters.AddWithValue("@game_id", game_id);

            //Get the element of the query
            var reader = cmd.ExecuteReader();
            db.CloseConnection();
            reader.Close();
        }

        public List<Game> SearchGames()
        {
            List<Game> games = new List<Game>();
            db.OpenConnection();
            string stmt = "SELECT * FROM game WHERE nr_seats > 0 ORDER BY nr_seats DESC";
            MySqlCommand cmd = new MySqlCommand(stmt, db.myConnection);

            //Get the element of the query
            var reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Game game = new Game { id = reader.GetInt16("game_id"), team1 = reader.GetString("home"), team2 = reader.GetString("away"), title = reader.GetString("title"), tickets = reader.GetInt16("nr_seats"), price = reader.GetInt16("price") };
                games.Add(game);
            }

            db.CloseConnection();
            reader.Close();

            return games;
        }



    }
}
