using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Banque.Models;
using Microsoft.AspNetCore.Mvc;

namespace Banques.Controllers
{
    [ApiController]
    [Route("api/TransactionController")]
    public class TransactionController : ControllerBase{
        private  Transactions[] ListeTransactions(){
            Transactions op = new Transactions();
            Connexion con = new Connexion();
            Transactions[] listOp = op.selectTransactions(con);
            return listOp;
        }
        [HttpGet]
        public IEnumerable<Transactions> GetAll()
        {
            return ListeTransactions();
        }
        
    }
}