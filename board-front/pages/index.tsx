import {useState, useEffect} from 'react';

export default function Home() {
    const [boards, setBoards] = useState([]);

    useEffect(() => {
        (async () => {
            const {data} = await (await fetch(`http://localhost:8080/post?page=1&size=8`)).json();
            console.log(data)
            setBoards(data);
        })();
    }, []);

    if (!boards) {
        return <div>Loading data...</div>;
    }

    const list = boards.map(board => (
        <div className="lg:w-1/4 md:w-1/2 p-4 w-full" key={board.postId}>
            <a className="block relative h-48 rounded overflow-hidden">
                {/*<image alt="ecommerce" className="object-cover object-center w-full h-full block"*/}
                {/*     src="https://dummyimage.com/420x260">*/}
            </a>
            <div className="mt-4">
                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">{board.title}</h3>
                <h2 className="text-gray-900 title-font text-lg font-medium">{board.content}</h2>
                <p className="mt-1">{board.likes ? board.likes.length : 0}</p>
            </div>
        </div>
    ));

    return (
        <section className="text-gray-600 body-font">
            <div className="container px-5 py-24 mx-auto">
                <div className="flex flex-wrap -m-4">
                    {list}
                </div>
            </div>
        </section>
    )
}
