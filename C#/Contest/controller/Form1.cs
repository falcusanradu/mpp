using Contest.model;
using Contest.service;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Contest
{
    public partial class Form1 : Form
    {
        /*   public Form1(DataBaseConnection dbconn)
           {
               db = dbconn;
               service = new Service(db);
           } */
        IService service;
        DataBaseConnection db;

        public Form1()
        {
            InitializeComponent();
            db = new DataBaseConnection();
            service = new Service(db);
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }



        private void button3_Click(object sender, EventArgs e)
        {
            richTextBox1.Clear();
            List<Game> games = service.ReturnGames();
            int i = games.Count;
            int j = 0;
            while (i > 0)
            {
                richTextBox1.AppendText(games.ElementAt(j).ToString());
                richTextBox1.AppendText("\n");
                j++;
                i--;
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            richTextBox1.Clear();
            List<Game> games = service.SearchGames();
            int i = games.Count;
            int j = 0;
            while (i > 0)
            {
                richTextBox1.AppendText(games.ElementAt(j).ToString());
                richTextBox1.AppendText("\n");
                j++;
                i--;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            richTextBox1.Clear();
            if (string.IsNullOrWhiteSpace(textBox1.Text) || string.IsNullOrWhiteSpace(textBox2.Text) || string.IsNullOrWhiteSpace(textBox3.Text))
            {
                MessageBox.Show("Name, number or game missing", "Error", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            } else
            {
                service.Buy(textBox1.Text, Convert.ToInt16(textBox2.Text), Convert.ToInt16(textBox3.Text));
                textBox1.Clear();
                textBox2.Clear();
                textBox3.Clear();
                List<Game> games = service.ReturnGames();
                int i = games.Count;
                int j = 0;
                while (i > 0)
                {
                    richTextBox1.AppendText(games.ElementAt(j).ToString());
                    richTextBox1.AppendText("\n");
                    j++;
                    i--;
                }
            }
                
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Login form2 = new Login();
            form2.Show();
            this.Close();
            textBox1.Clear();
            textBox2.Clear();
        }
    }
}
