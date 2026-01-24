namespace SimpleAsyc
{
    public partial class Form1 : Form
    {
        static void BigTask()
        {
            Thread.Sleep(10000);
        }

        public Form1()
        {
            InitializeComponent();
        }

        private async void button1_Click(object sender, EventArgs e)
        {
          //  BigTask();
            await Task.Run(new Action(BigTask));
            label1.Text = "Task Done";
        }

        private void Form1_Load(object sender, EventArgs e)
        {
        }

        private void button2_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Test");
        }
    }
}
