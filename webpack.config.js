/**
 * Created by sousic on 2017. 3. 8..
 */

var path = require('path')

module.exports = {
    entry: { //엔트리 파일 목록
        lib: ['./node_modules/jquery/dist/jquery.js', './node_modules/handlebars/dist/handlebars.runtime.js']
    },
    output: {
        path: path.join(__dirname, '/src/main/webapp/resources/js/'), //번들 파일 폴더
        filename: 'lib.bundle.js'
    }
};