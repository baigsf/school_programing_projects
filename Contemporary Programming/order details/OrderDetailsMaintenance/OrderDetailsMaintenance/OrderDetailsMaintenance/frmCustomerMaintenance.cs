using System;
using System.Windows.Forms;
using OrderDetailsMaintenance.Models.DataLayer;

namespace OrderDetailsMaintenance
{
    public partial class frmCustomerMaintenance : Form
    {
        private NorthwindContext _context = new NorthwindContext();
        private Customer _currentCustomer;

        public frmCustomerMaintenance()
        {
            InitializeComponent();

            
            btnFind.Click += btnFind_Click;
            btnSave.Click += btnSave_Click;
            btnExit.Click += btnExit_Click;
        }

        
        private void btnFind_Click(object sender, EventArgs e)  //Saif Baig
        {
            string customerId = txtCustomerId.Text.Trim();

            if (string.IsNullOrEmpty(customerId))
            {
                MessageBox.Show("Please enter a Customer ID.");
                return;
            }

            _currentCustomer = _context.Customers.Find(customerId);

            if (_currentCustomer != null)
            {
                txtContact.Text = _currentCustomer.ContactName;
                txtAddress.Text = _currentCustomer.Address;
                txtCity.Text = _currentCustomer.City;
                txtCountry.Text = _currentCustomer.Country;
            }
            else
            {
                MessageBox.Show("Customer not found.");
            }
        }

       
        private void btnSave_Click(object sender, EventArgs e)  //Saif Baig
        {
            if (_currentCustomer == null)
            {
                MessageBox.Show("Please find a customer first.");
                return;
            }

            _currentCustomer.ContactName = txtContact.Text.Trim();
            _currentCustomer.Address = txtAddress.Text.Trim();
            _currentCustomer.City = txtCity.Text.Trim();
            _currentCustomer.Country = txtCountry.Text.Trim();

            _context.Customers.Update(_currentCustomer);
            _context.SaveChanges();

            MessageBox.Show("Customer information updated successfully.");
        }

       
        private void btnExit_Click(object sender, EventArgs e)  //Saif Baig
        {
            this.Close();
        }

      
        protected override void OnFormClosing(FormClosingEventArgs e)
        {
            _context.Dispose();
            base.OnFormClosing(e);
        }
    }
}