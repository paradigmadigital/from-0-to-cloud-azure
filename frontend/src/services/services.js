import axios from "axios";
export default {
    // Function that make a get to the related serviceUrl
    get: function(serviceUrl){
        const request = axios.get(serviceUrl)        
        return request
        .then(result => result)
        .catch(error => error)

    },

    // Function that make a get to the related serviceUrl
    del: function(serviceUrl){
        return new Promise(resolve => {
            axios.delete(serviceUrl)
            .then(function(data) {
                try{
                    console.log('DELETE OK');
                    resolve(data);
                } catch (e){
                    console.log('DELETE KO');
                    resolve({error: e});
                }
            })
            .catch(function (error){
                resolve({error});
            });
        });
    },

    //Function that make a post to add new element into BD
    add: function(serviceURL, item){
        return new Promise(resolve => {
            axios.post(serviceURL, item)
            .then(function(data) {
                try{
                    console.log('POST OK');
                    resolve(data);
                } catch (e){
                    console.log('POST KO');
                    resolve({error: e});
                }
            })
            .catch(function (error){
                resolve({error});
            });
        });
    },

    //Function that make a put to update an element into BD
    update: function(serviceURL, item){
        return new Promise(resolve => {
            axios.put(serviceURL, item)
            .then(function(data) {
                try{
                    console.log('PUT OK');
                    resolve(data);
                } catch (e){
                    console.log('PUT KO');
                    resolve({error: e});
                }
            })
            .catch(function (error){
                resolve({error});
            });
        });
    }
};