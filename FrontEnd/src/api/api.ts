import axios from 'axios';

export default async function API(
  endpoint: string,
  method: 'GET' | 'POST' | 'PUT' | 'DELETE',
  body: any
) {
  const API_URL = process.env.REACT_APP_API_URL || "http://localhost:8080"; 

  const url = `${API_URL}${endpoint}`; 

  try {
    const response = await axios({
      method,
      url,
      data: body,
    });
    return response.data; 
  } catch (error) {
    console.error('API 요청 오류:', error);
    throw error; 
  }
}
