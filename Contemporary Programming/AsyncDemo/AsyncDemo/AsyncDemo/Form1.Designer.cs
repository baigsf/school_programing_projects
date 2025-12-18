namespace AsyncDemo
{
    partial class Form1
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
            label1 = new Label();
            txtFileName = new TextBox();
            btnBrowse = new Button();
            listBox1 = new ListBox();
            button1 = new Button();
            button2 = new Button();
            openFileDialog = new OpenFileDialog();
            listBox2 = new ListBox();
            label2 = new Label();
            txtFileName2 = new TextBox();
            btnBrowse2 = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(87, 58);
            label1.Margin = new Padding(2, 0, 2, 0);
            label1.Name = "label1";
            label1.Size = new Size(60, 15);
            label1.TabIndex = 0;
            label1.Text = "File Name";
            // 
            // txtFileName
            // 
            txtFileName.Location = new Point(178, 55);
            txtFileName.Margin = new Padding(2);
            txtFileName.Name = "txtFileName";
            txtFileName.Size = new Size(156, 23);
            txtFileName.TabIndex = 1;
            // 
            // btnBrowse
            // 
            btnBrowse.Location = new Point(364, 55);
            btnBrowse.Margin = new Padding(2);
            btnBrowse.Name = "btnBrowse";
            btnBrowse.Size = new Size(97, 23);
            btnBrowse.TabIndex = 2;
            btnBrowse.Text = "Browse";
            btnBrowse.UseVisualStyleBackColor = true;
            btnBrowse.Click += btnBrowse_Click;
            // 
            // listBox1
            // 
            listBox1.FormattingEnabled = true;
            listBox1.ItemHeight = 15;
            listBox1.Location = new Point(87, 130);
            listBox1.Margin = new Padding(2);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(374, 229);
            listBox1.TabIndex = 3;
            // 
            // button1
            // 
            button1.Location = new Point(611, 91);
            button1.Margin = new Padding(2);
            button1.Name = "button1";
            button1.Size = new Size(97, 24);
            button1.TabIndex = 4;
            button1.Text = "Exit";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // button2
            // 
            button2.Location = new Point(406, 91);
            button2.Margin = new Padding(2);
            button2.Name = "button2";
            button2.Size = new Size(93, 25);
            button2.TabIndex = 5;
            button2.Text = "Submit";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // openFileDialog
            // 
            openFileDialog.FileName = "openFileDialog";
            // 
            // listBox2
            // 
            listBox2.FormattingEnabled = true;
            listBox2.ItemHeight = 15;
            listBox2.Location = new Point(648, 130);
            listBox2.Margin = new Padding(2);
            listBox2.Name = "listBox2";
            listBox2.Size = new Size(374, 229);
            listBox2.TabIndex = 6;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(648, 54);
            label2.Margin = new Padding(2, 0, 2, 0);
            label2.Name = "label2";
            label2.Size = new Size(60, 15);
            label2.TabIndex = 7;
            label2.Text = "File Name";
            // 
            // txtFileName2
            // 
            txtFileName2.Location = new Point(748, 50);
            txtFileName2.Margin = new Padding(2);
            txtFileName2.Name = "txtFileName2";
            txtFileName2.Size = new Size(156, 23);
            txtFileName2.TabIndex = 8;
            // 
            // btnBrowse2
            // 
            btnBrowse2.Location = new Point(925, 49);
            btnBrowse2.Margin = new Padding(2);
            btnBrowse2.Name = "btnBrowse2";
            btnBrowse2.Size = new Size(97, 23);
            btnBrowse2.TabIndex = 9;
            btnBrowse2.Text = "Browse";
            btnBrowse2.UseVisualStyleBackColor = true;
            btnBrowse2.Click += btnBrowse2_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1131, 443);
            Controls.Add(btnBrowse2);
            Controls.Add(txtFileName2);
            Controls.Add(label2);
            Controls.Add(listBox2);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(listBox1);
            Controls.Add(btnBrowse);
            Controls.Add(txtFileName);
            Controls.Add(label1);
            Margin = new Padding(2);
            Name = "Form1";
            Text = "SaifBaigAsync";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox txtFileName;
        private Button btnBrowse;
        private ListBox listBox1;
        private Button button1;
        private Button button2;
        private OpenFileDialog openFileDialog;
        private ListBox listBox2;
        private Label label2;
        private TextBox txtFileName2;
        private Button btnBrowse2;
    }
}
