using Contest.model;
using Contest.repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Contest.service
{
    class Service : IService
    {
        private DataBaseConnection db;
        private IClientRepository clientRepository;
        private IGameRepository gameRepository;
        private IUserRepository userRepository;

        public Service(DataBaseConnection dbconn)
        {
            db = dbconn;
            clientRepository = new ClientRepository(db);
            gameRepository = new GameRepository(db);
            userRepository = new UserRepository(db);
        }
       

        public void Buy(string name_client, int nr_seats, int game_id)
        {
            clientRepository.Buy(name_client, nr_seats, game_id);
        }

        public Boolean Validate(String username, String passwd)
        {
            return userRepository.Validate(username, passwd);
        }

        public List<Game> ReturnGames()
        {
            return gameRepository.ReturnGames();
        }

        public void UpdateSeats(int nr_seats, int game_id)
        {
            gameRepository.UpdateSeats(nr_seats, game_id);
        }

        public List<Game> SearchGames()
        {
            return gameRepository.SearchGames();
        }
    }
}
