const { MongoClient, ServerApiVersion } = require('mongodb');
const uri = "mongodb+srv://admin:0000@cluster0.1qsrdge.mongodb.net/?retryWrites=true&w=majority";

const client = new MongoClient(uri, {
    serverApi: {
      version: ServerApiVersion.v1,
      strict: true,
      deprecationErrors: true,
    }
  });

client.connect();

module.exports = client;