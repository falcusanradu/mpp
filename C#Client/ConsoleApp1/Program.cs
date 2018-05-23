using System;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;


namespace CSharpREST
{
    class MainClass
    {
        static HttpClient client = new HttpClient();

        public static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            try
            {
                RunAsync().Wait();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }


        static async Task RunAsync()
        {
            client.BaseAddress = new Uri("http://localhost:8080/game/games");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            int id = 32;
            Console.WriteLine("Get Game {0}", id);
            Game result = await GetGameAsync("http://localhost:8080/game/" + id);
            Console.WriteLine("Am primit {0}", result);
            Console.ReadLine();
        }

        static async Task<String> GetTextAsync(string path)
        {
            String product = null;
            HttpResponseMessage response = await client.GetAsync(path);
            if (response.IsSuccessStatusCode)
            {
                product = await response.Content.ReadAsStringAsync();
            }
            return product;
        }


        static async Task<Game> GetGameAsync(string path)
        {
            Game product = null;
            HttpResponseMessage response = await client.GetAsync(path);
            if (response.IsSuccessStatusCode)
            {
                product = await response.Content.ReadAsAsync<Game>();
            }
            return product;
        }

    }
    public class Game
    {
        private int id { get; set; }
        private string team1 { get; set; }
        private string team2 { get; set; }
        private string title { get; set; }
        private int tickets { get; set; }
        private int priceOfTicket { get; set; }

        public override string ToString()
        {
            return string.Format("[Game: Id={0}, title={1}]", id, title);
        }

    }

}

