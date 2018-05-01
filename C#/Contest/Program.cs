using Contest.model;
using Contest.repository;
using Contest.service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Contest
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Login());
            DataBaseConnection db = new DataBaseConnection();

            IService service = new Service(db);

            ClientRepository clientRepository = new ClientRepository(db);
            // service.Buy("paulica", 20, 3);
            
            service.Validate("olaf", "olaf");
          
            service.Validate("olaf", "anna");
            service.Validate("olaf", "olaf");
        }
    }
}
