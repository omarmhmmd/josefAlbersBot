// Using the Twit node package
// https://github.com/ttezel/twit
var Twit = require('twit');

// Pulling all my twitter account info from another file
var config = require('./config.js');
// Making a Twit object for connection to the API
var T = new Twit(config);
// Require child_process for triggering script for Processing
var exec = require('child_process').exec;
// For reading image files
var fs = require('fs');

// Here is the bot!
function tweeter() {
  // Here is the command to run the Processing sketch
  // You need to have Processing command line installed
  // See: https://github.com/processing/processing/wiki/Command-Line
  //var cmd = 'processing-java --sketch=`pwd`/albers/ --run';
  var cmd = 'albersReply/albersReply';
  exec(cmd, processing);
  // Callback for command line process
  function processing(error, stdout, stderr) {
    // I could do some error checking here
    console.log("processing");

    // Read the file made by Processing
    var b64content = fs.readFileSync('albers/albers.png', { encoding: 'base64' })
    // Upload the media
    T.post('media/upload', { media_data: b64content }, uploaded);

    function uploaded(err, data, response) {
      // Now we can reference the media and post a tweet
      // with the media attached
      var mediaIdStr = data.media_id_string;
      var params = { status: "#homagetothesquare 00" + i, media_ids: [mediaIdStr] }
      // Post tweet
      T.post('statuses/update', params, tweeted);
      i++;
    };

    // Callback for when the tweet is sent
    function tweeted(err, data, response) {
      if (err) {
        console.log("not tweeted");
      } else {
        console.log('Success: ' + data.text);
        //console.log(response);
      }
    };
  }
}
