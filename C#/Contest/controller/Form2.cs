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
    public partial class Login : Form
    {
        IService service;
        DataBaseConnection db;

        public Login()
        {
            InitializeComponent();
            db = new DataBaseConnection();
            service = new Service(db);
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(textBox1.Text) || string.IsNullOrWhiteSpace(textBox2.Text))
            {
                MessageBox.Show("Username and password required");
            } else
            {
                if (service.Validate(textBox1.Text, textBox2.Text))
                {   
                    
                    Form1 form1 = new Form1();
                    form1.Show();
                    this.Hide();
                    
                } else
                {
                    MessageBox.Show("Wrong username or password");
                    textBox1.Clear();
                    textBox2.Clear();
                }
            }
            
        }
    }
}
