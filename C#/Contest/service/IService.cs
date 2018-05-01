using Contest.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Contest.service
{
    interface IService
    { 
        void Buy(string name_client, int nr_seats, int game_id);
        List<Game> ReturnGames();
        void UpdateSeats(int nr_seats, int game_id);
        List<Game> SearchGames();
        Boolean Validate(String username, String passwd);
    }
}
