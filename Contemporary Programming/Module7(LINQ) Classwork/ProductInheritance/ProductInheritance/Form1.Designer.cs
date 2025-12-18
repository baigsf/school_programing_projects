namespace ProductInheritance
{
    partial class ProductMaintenance
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            lstProducts = new ListBox();
            lstInvoices = new ListBox();
            lstFiltered = new ListBox();
            SuspendLayout();
            // 
            // lstProducts
            // 
            lstProducts.FormattingEnabled = true;
            lstProducts.ItemHeight = 25;
            lstProducts.Location = new Point(53, 61);
            lstProducts.Name = "lstProducts";
            lstProducts.Size = new Size(475, 129);
            lstProducts.TabIndex = 0;
            // 
            // lstInvoices
            // 
            lstInvoices.FormattingEnabled = true;
            lstInvoices.ItemHeight = 25;
            lstInvoices.Location = new Point(48, 220);
            lstInvoices.Name = "lstInvoices";
            lstInvoices.Size = new Size(379, 204);
            lstInvoices.TabIndex = 1;
            // 
            // lstFiltered
            // 
            lstFiltered.FormattingEnabled = true;
            lstFiltered.ItemHeight = 25;
            lstFiltered.Location = new Point(433, 220);
            lstFiltered.Name = "lstFiltered";
            lstFiltered.Size = new Size(355, 204);
            lstFiltered.TabIndex = 2;
            // 
            // ProductMaintenance
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(lstFiltered);
            Controls.Add(lstInvoices);
            Controls.Add(lstProducts);
            Name = "ProductMaintenance";
            Text = "Product Maintenance";
            Load += ProductMaintenance_Load;
            ResumeLayout(false);
        }

        #endregion

        private ListBox lstProducts;
        private ListBox lstInvoices;
        private ListBox lstFiltered;
    }
}
