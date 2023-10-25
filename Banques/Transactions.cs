using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;
using Banque.Models;

namespace Banque.Models
{
    public class Transactions
    {
        int idTransaction;
        string nomTransaction;

        public Transactions[] selectTransactions(Connexion c){
            SqlConnection con = c.connexion();
            con.Open();
            List<Transactions> postes = new List<Transactions>();
            string requete = "SELECT * FROM Transactions";
            SqlCommand cmd = new SqlCommand(requete, con);
            SqlDataReader reader = cmd.ExecuteReader();
            while(reader.Read()){
                Transactions trans = new Transactions(reader.GetInt32(0),reader.GetString(1));
                postes.Add(trans);
            }
            con.Close();
            return postes.ToArray();
        }
        public Transactions(int idTransaction,string nomTransaction)
        {
            this.nomTransaction = nomTransaction;
            this.idTransaction = idTransaction;
        }

        public Transactions()
        {
        }

        public int IdTransaction { get => idTransaction; set => idTransaction = value; }
        public string NomTransaction { get => nomTransaction; set => nomTransaction = value; }
    }
}