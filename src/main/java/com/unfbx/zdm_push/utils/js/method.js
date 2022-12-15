
// function decrypt(str, key) {
//     var key = CryptoJS.MD5(key).toString();
//     var crypto_key = CryptoJS.enc.Utf8.parse(key);
//     var decrypt_str = CryptoJS.TripleDES.decrypt(str, crypto_key, {
//         mode: CryptoJS.mode.ECB,
//         padding: CryptoJS.pad.Pkcs7
//     });
//     return decrypt_str.toString(CryptoJS.enc.Utf8)
// }

// var str = "3HiOvQ/OhuQU4JZIQU70OyNZ5I1JPlGUEkbDfDsoTajqYyxIhUuFkdtBiHbpmPvbc3ITVYk/gLk40ebcFw0KVA=="
// var code = "OD73FoddW5tNNqOPtOTn/S8TqxRdcfDZ8fko+BohZ2s="


// function decrypt(str,key){var key=CryptoJS.MD5(key).toString();var crypto_key=CryptoJS.enc.Utf8.parse(key);var decrypt_str=CryptoJS.TripleDES.decrypt(str,crypto_key,{mode:CryptoJS.mode.ECB,padding:CryptoJS.pad.Pkcs7});return decrypt_str.toString(CryptoJS.enc.Utf8)}
// dercypt("SIg54C9I0rgA8RG6E8JAQqc1O5uKrZCqUIDALEZ2nFnSwuVIfsPOiOFccC4LSAGtGeYgealuH3ISKcGp5vQ8TA==","Yc0l8kliNcvMqQlz5EgsrC8TqxRdcfDZ8fko+BohZ2s=")
//  magnet:?xt=urn:btih:EE48261CCAE18F799965921929CA92847B909234


function getCode(h1,u1,n1,t1,e1,r1){
    var demo = ["", "split", "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/", "slice", "indexOf", "", "", ".", "pow", "reduce", "reverse", "0"];

    function decryption(d, e, f) {
        var g = demo[2][demo[1]](demo[0]);
        var h = g[demo[3]](0, e);
        var i = g[demo[3]](0, f);
        var j = d[demo[1]](demo[0])[demo[10]]()[demo[9]](function (a, b, c) {
            if (h[demo[4]](b) !== -1) return a += h[demo[4]](b) * (Math[demo[8]](e, c))
        }, 0);
        var k = demo[0];
        while (j > 0) {
            k = i[j % f] + k;
            j = (j - (j % f)) / f
        }
        return k || demo[11]
    }

    function jiemi(h, u, n, t, e, r) {
        r = "";
        for (var i = 0, len = h.length; i < len; i++) {
            var s = "";
            while (h[i] !== n[e]) {
                s += h[i];
                i++
            }
            for (var j = 0; j < n.length; j++) s = s.replace(new RegExp(n[j], "g"), j);
            r += String.fromCharCode(decryption(s, e, 10) - t)
        }
        return decodeURIComponent(escape(r))
    }

    var d_code = jiemi(h1,u1,n1,t1,e1,r1).toString().substr(12,44)
    console.log(d_code)
    return d_code


    //
    // var v_code = jiemi(h1,u1,n1,t1,e1,r1).toString()
    // // console.log(v_code)
    // var code = v_code.substr(12,44);
    // console.log(code)
    // return (code)


}

getCode("TsJsXEJEJXTsTsXJETXEJTTXEJEEXEJTEXTsEEXEJTTXEJTJXEEsJXJJEXETEEXEETTXEsJEXEsTEXEEJsXTsEEXEJTTXEJTTXETJEXEsTJXTsTTXETEsXETEsXTsEJXETEEXETETXTsTTXETEEXETTTXTsEsXEsEEXETTEXEsJTXETTTXTsEJXTsJTXETTsXEJTTXEJTEXEJJsXEETTXEJssXEsJTXEJJsXTssEXTsEEXEssEXEETsXTsEEXEJJTXEJssXEsTsXTsTEXEEsJXJJEXEEsEX", 5, "sETJXnPFz", 22, 4, 42);

// ("TsJsXEJEJXTsTsXJETXEJTTXEJEEXEJTEXTsEEXEJTTXEJTJXEEsJXJJEXETEEXEETTXEsJEXEsTEXEEJsXTsEEXEJTTXEJTTXETJEXEsTJXTsTTXETEsXETEsXTsEJXETEEXETETXTsTTXETEEXETTTXTsEsXEsEEXETTEXEsJTXETTTXTsEJXTsJTXETTsXEJTTXEJTEXEJJsXEETTXEJssXEsJTXEJJsXTssEXTsEEXEssEXEETsXTsEEXEJJTXEJssXEsTsXTsTEXEEsJXJJEXEEsEX", 5, "sETJXnPFz", 22, 4, 42));

// console.log(getCode("TsJsXEJEJXTsTsXJETXEJTTXEJEEXEJTEXTsEEXEJTTXEJTJXEEsJXJJEXETEEXEETTXEsJEXEsTEXEEJsXTsEEXEJTTXEJTTXETJEXEsTJXTsTTXETEsXETEsXTsEJXETEEXETETXTsTTXETEEXETTTXTsEsXEsEEXETTEXEsJTXETTTXTsEJXTsJTXETTsXEJTTXEJTEXEJJsXEETTXEJssXEsJTXEJJsXTssEXTsEEXEssEXEETsXTsEEXEJJTXEJssXEsTsXTsTEXEEsJXJJEXEEsEX",5,"sETJXnPFz",22,4,42))


