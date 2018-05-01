using MySql.Data.MySqlClient;
using System;


namespace Contest
{
    class DataBaseConnection
    {
            public MySqlConnection myConnection;
            public static DataBaseConnection db;


            public DataBaseConnection()
            {
                try
                {
                    if (myConnection == null)
                    {
                        string connstring = string.Format("Server=localhost; database=mpp_db_csarp; UID=Admin; password=1234");
                        myConnection = new MySqlConnection(connstring);
                    }
                }
                catch (Exception)
                {
                    System.Console.WriteLine("ERROR - Database not found!");
                }

                db = this;
            }

            public void OpenConnection()
            {
                if (myConnection.State != System.Data.ConnectionState.Open)
                {
                    myConnection.Open();
                }
            }

            public void CloseConnection()
            {
                if (myConnection.State != System.Data.ConnectionState.Closed)
                {
                    myConnection.Close();
                }
            }
        }

    }
