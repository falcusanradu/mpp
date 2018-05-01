using Contest.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Contest.repository
{
    interface IGameRepository
    {
         List<Game> ReturnGames();
         void UpdateSeats(int nr_seats, int game_id);
         List<Game> SearchGames();
    }
}
