let rate={
    USD:24183,
    VND:1,
    EUR:23119,
    GBP:26666,
    SGD:16526,
    JPY:156.9
}

function getQuanity()
{
    let a = parseInt(document.getElementById("quanity").value);
    let b = document.getElementById("currency").value;
    let c = document.getElementById("currency1").value;
    let r1 = rate[b];
    let r2 = rate[c]
    let r;
    r = a*r1/r2;
    return document.getElementById("result").textContent=r;

}