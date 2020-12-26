from pymongo import MongoClient

client = MongoClient("mongodb://ayunas:dataYunas1@cluster0-shard-00-00.yr7ty.mongodb.net:27017,cluster0-shard-00-01.yr7ty.mongodb.net:27017,cluster0-shard-00-02.yr7ty.mongodb.net:27017/sample_airbnb?ssl=true&replicaSet=atlas-fszi9e-shard-0&authSource=admin&retryWrites=true&w=majority")

db = client.sample_airbnb

db.user.insert({"_id" : 21, "name" : "XYZ", "age" : 34, "contacts" : ["23432", "234234"]})

