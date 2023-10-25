using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace Banque.Models
{
    public class Operation{
        int idOperation;
        int idTransaction;
        double montant;
        string cinR;
        string cinE;
        DateTime dates;
        double volany;
        string nomTransaction;
        public Operation(double volany){
            this.volany = volany;
        }
        public int IdOperation { get => idOperation; set => idOperation = value; }
        public int IdTransaction { get => idTransaction; set => idTransaction = value; }
        public double Montant { get => montant; set => montant = value; }
        public string CinR { get => cinR; set => cinR = value; }
        public string CinE { get => cinE; set => cinE = value; }
        public DateTime Dates { get => dates; set => dates = value; }
        public string NomTransaction { get => nomTransaction; set => nomTransaction = value; }
        public double Volany { get => volany; set => volany = value; }

        public Operation(int idTransaction,double montant,string cinR,string cinE,DateTime date){
            if(montant > 0){
                this.IdTransaction = idTransaction;
                this.Montant = montant;
                this.CinR = cinR;
                this.CinE = cinE;
                this.dates = date;
            }else{
                Console.WriteLine("Prix Non Valide");
                throw new Exception("Prix Non Valide");
            }
        }
        public void insertionOperation(Connexion c){
            SqlConnection con =  c.connexion();
            con.Open();
            string requete = "INSERT INTO operation  (idTransaction, Montant, cinRecepteur, cinEnvoyeur,Dates) VALUES (@idTransaction, @Montant, @cinRecepteur, @cinEnvoyeur,@Dates)";
            SqlCommand cmd = new SqlCommand(requete, con);
            cmd.Parameters.AddWithValue("@idTransaction", IdTransaction);
            cmd.Parameters.AddWithValue("@Montant", Montant);
            cmd.Parameters.AddWithValue("@cinRecepteur", CinR);
            cmd.Parameters.AddWithValue("@cinEnvoyeur", CinE);
            cmd.Parameters.AddWithValue("@Dates", Dates);
            cmd.ExecuteNonQuery();
            con.Close();
        }
        public Operation[] selectOperation(Connexion c){
            SqlConnection con = c.connexion();
            con.Open();
            List<Operation> postes = new List<Operation>();
            string requete = "select t.nomTransaction,o.montant,o.cinRecepteur,o.cinEnvoyeur,o.dates from operation o join TRANSACTIONS t on o.idTransaction = t.idTransaction";
            SqlCommand cmd = new SqlCommand(requete, con);
            SqlDataReader reader = cmd.ExecuteReader();
            while(reader.Read()){
                Operation trans = new Operation(reader.GetString(0),reader.GetDouble(1),reader.GetString(2),reader.GetString(3),reader.GetDateTime(4));
                postes.Add(trans);
            }
            con.Close();
            return postes.ToArray();
        }
        public Operation selectMontant (Connexion c,string cinR){
            SqlConnection con = c.connexion();
            con.Open();
            List<Operation> postes = new List<Operation>();
            string requete = "select sum(montant) volany,cinRecepteur from operation  where CINRecepteur="+cinR+"  group by CINRecepteur";
            Console.WriteLine(requete);
            SqlCommand cmd = new SqlCommand(requete, con);
            SqlDataReader reader = cmd.ExecuteReader();
            if(reader.Read()){
                Operation trans = new Operation(reader.GetDouble(0));
                postes.Add(trans);
            }
            con.Close();
            return postes.ToArray()[0];
        }
        public Operation(string nomTransaction,double montant,string cinR,string cinE,DateTime date){
            this.NomTransaction = nomTransaction;
            this.Montant = montant;
            this.CinR = cinR;
            this.CinE = cinE;
        }
        public Operation(){
        }
    }
}