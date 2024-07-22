import axios from 'axios'
export default async function wal() {

    const response = await axios.post('/wal')
    /*.then((res) => {
        setHello(res.data)
    })*/

    return response.data
}