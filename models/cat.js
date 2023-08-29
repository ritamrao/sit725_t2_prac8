let client = require('../dbConnection');

let collection = client.db().collection('Cats');

function postCat(cat,callback) {
    collection.insertOne(cat,callback);
}

function getAllCats(callback){
    collection.find({}).toArray(callback);
}

function deleteCats(cat,callback) {
    collection.deleteOne(cat, callback);
}   


module.exports = {postCat,getAllCats, deleteCats}