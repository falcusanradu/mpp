using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Contest.repository
{
    interface IClientRepository
    {
       void Buy(String name_client, int nr_seats, int game_id);
    }
}
