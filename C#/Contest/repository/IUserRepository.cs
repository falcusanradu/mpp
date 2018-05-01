using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Contest.repository
{
    interface IUserRepository
    {
         Boolean Validate(String username, String passwd);
    }
}
