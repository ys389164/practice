import axios from 'axios'

const baseUrl = process.env.BASE_URL

export default async function TestF() {

    const response = await axios.get('/api/hello')
            /*.then((res) => {
                setHello(res.data)
            })*/

    return response.data
}