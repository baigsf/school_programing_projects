namespace AsyncDemo
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        // Browse button for the first file
        private void btnBrowse_Click(object sender, EventArgs e)
        {
            DialogResult result = this.openFileDialog.ShowDialog();
            if (result == DialogResult.OK)
            {
                // Store the full file path in the text box
                txtFileName.Text = openFileDialog.FileName;
            }
        }

        // Browse button for the second file
        private void btnBrowse2_Click(object sender, EventArgs e)
        {
            DialogResult result = this.openFileDialog.ShowDialog();
            if (result == DialogResult.OK)
            {
                // Store the full file path in the text box
                txtFileName2.Text = openFileDialog.FileName;
            }
        }

        // Main button to start processing the files
        private async void button2_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            listBox2.Items.Clear();

            // Get the full file paths from the text boxes
            var file1 = txtFileName.Text;
            var file2 = txtFileName2.Text;

            // Basic validation to ensure files have been selected
            if (string.IsNullOrWhiteSpace(file1) || string.IsNullOrWhiteSpace(file2))
            {
                MessageBox.Show("Please select two text files to process.");
                return;
            }

            try
            {
                // Create and run both processing tasks concurrently
                Task processTask1 = ProcessBookAsync(file1, listBox1);
                Task processTask2 = ProcessBookAsync(file2, listBox2);

                // Wait for both tasks to complete before continuing
                await Task.WhenAll(processTask1, processTask2);

                MessageBox.Show("Processing complete!");
            }
            catch (Exception ex)
            {
                // Catch potential errors like "file not found"
                MessageBox.Show($"An error occurred: {ex.Message}");
            }
        }

        // Button to close the application
        private void button1_Click(object sender, EventArgs e)
        {
            Close();
        }


    
        private async Task ProcessBookAsync(string filename, ListBox targetListBox) //Saif Baig
        {
            string[] lines = await File.ReadAllLinesAsync(filename);

            var words = lines.AsParallel() 
                .Where(line => !string.IsNullOrWhiteSpace(line))
                .SelectMany(line => line.ToLower()
                    .Replace(",", "").Replace("'", "").Replace("{", "").Replace("}", "")
                    .Split(new[] { ' ', '\t', '\r', '\n' }, StringSplitOptions.RemoveEmptyEntries));

            var wordCounts = words
                .GroupBy(word => word)
                .ToDictionary(group => group.Key, group => group.Count());

            var top10 = wordCounts
                .OrderByDescending(pair => pair.Value)
                .Take(10);

     
            foreach (var entry in top10)
            {
                targetListBox.Items.Add($"{entry.Key} - {entry.Value}");
            }
        }
    }
}