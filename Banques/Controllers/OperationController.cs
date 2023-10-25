using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Banque.Models;
using Microsoft.AspNetCore.Mvc;

namespace Banques.Controllers
{
    [ApiController]
    [Route("api/OperationController")]
    public class OperationController : ControllerBase
    {
        private  Operation[] ListeOperation(){
            Operation op = new Operation();
            Connexion con = new Connexion();
            Operation[] listOp = op.selectOperation(con);
            Console.WriteLine(listOp.Count());
            return listOp;
        }
        [HttpGet]
        public IEnumerable<Operation> GetAll()
        {
            return ListeOperation();
        }
        [HttpGet("InsertionOperation")]
        public ActionResult InsertionOperation(int id,double montant,string cinR,string cinE,DateTime date)
        {
            try
            {
                Connexion c = new Connexion();
                Operation op = new Operation(id,montant,cinR,cinE,date);
                op.insertionOperation(c);
                Console.WriteLine($"ID : {op.IdTransaction}, montant : {op.Montant},cinR: {op.CinR}, cinE:{op.CinE}, date:{op.Dates}");
                return NoContent(); // Aucune donnée à renvoyer, statut 204 No Content.
            }
            catch (Exception ex)
            {
                // En cas d'erreur, renvoyez un code d'erreur avec un message.
                return BadRequest("Erreur : " + ex.Message);
            }
        }
        [HttpGet("selectMontant")]
        public double selectMontant(string cinR){
            Connexion c = new Connexion();
            Operation op = new Operation();
            op=op.selectMontant(c,cinR);
            Console.WriteLine($" montant : {op.Volany}");
            return op.Volany ; 
        }
    }
}