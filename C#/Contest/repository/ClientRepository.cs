using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Contest.repository
{
    class ClientRepository : IClientRepository

    {
        DataBaseConnection db;
        public ClientRepository(DataBaseConnection db)
        {
            this.db = db;
        }

        public void Buy(string name_client, int nr_seats, int game_id)
        {
            db.OpenConnection();
            string stmt = "insert into clients(name_client, nr_seats, game_id) values(@name_client, @nr_seats, @game_id)";
            MySql.Data.MySqlClient.MySqlCommand cmd = new MySql.Data.MySqlClient.MySqlCommand(stmt, db.myConnection);
            
            cmd.Parameters.AddWithValue("@name_client", name_client);
            cmd.Parameters.AddWithValue("@nr_seats", nr_seats);
            cmd.Parameters.AddWithValue("@game_id", game_id);
            var reader = cmd.ExecuteReader();

            GameRepository sRepo = new GameRepository(db);
            db.CloseConnection();
            sRepo.UpdateSeats(nr_seats, game_id);

            //Get the element of the query
            
          //  db.CloseConnection();
            reader.Close();
        }
    }
}
    
