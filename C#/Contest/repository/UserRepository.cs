using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Contest.repository
{
    class UserRepository : IUserRepository
    {
        DataBaseConnection db;
        public UserRepository(DataBaseConnection db)
        {
            this.db = db;
        }

        public Boolean Validate(String username, String passwd)
        {
            db.OpenConnection();
            string stmt = "select * from users where username=@username and passwd=@passwd";
            MySqlCommand cmd = new MySqlCommand(stmt, db.myConnection);
            cmd.Parameters.AddWithValue("@username", username);
            cmd.Parameters.AddWithValue("@passwd", passwd);

            //Get the element of the query
            
            var reader = cmd.ExecuteReader();
            if (reader.HasRows)
            {
                Console.WriteLine("Connected");
                reader.Close();
                db.CloseConnection();
                return true;
            }
            else
                Console.WriteLine("Wrong username/pass");
            db.CloseConnection();
            reader.Close();
            
            return false;
        }
    }
}
